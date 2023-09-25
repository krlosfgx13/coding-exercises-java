package org.example.coding.examples.threads;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ThreadExamples {
    public static final String MSSQL_CONNECTION_STRING = "jdbc:sqlserver://192.168.1.8:1433;databaseName=TEST;loginTimeout=30;encrypt=false;";
    public static String MSSQL_USER_NAME = "sa";
    public static String MSSQL_PASSWORD = "12345678";
    public static String MSSQL_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    /*
    * Scenarios:
    * Scenario 1: There is no order guaranteed, any of the three threads can be executed first. (t1, t2 and main).
      Thread thread1 = new Thread(ThreadExamples::Test1);
      Thread thread2 = new Thread(ThreadExamples::Test2);
      thread1.setName("Thread #1");
      thread2.setName("Thread #2");
      thread1.start();
      thread2.start();
      System.out.println("Executing: " + Thread.currentThread().getName());

    * Scenario 2: If I make two threads work at the same time to insert 10k records without synchronizing them, let's
    * say, without caring about the insertion order, the process will take about 8 seconds.
      Thread t1 = new Thread(ThreadExamples::TestDbThread1);
      Thread t2 = new Thread(ThreadExamples::TestDbThread2);
      thread1.setName("Thread #1");
      thread2.setName("Thread #2");
      thread1.start();
      thread2.start();

     * Scenario 3: If I make two threads but not to work at the same time, synchronizing them with the .join() method
     * for the second thread to wait for the first thread to finish.
      Thread t1 = new Thread(ThreadExamples::TestDbThread1);
      Thread t2 = new Thread(ThreadExamples::TestDbThread2);
      thread1.setName("Thread #1");
      thread2.setName("Thread #2");
      thread1.start();
      thread1.join();
      thread2.start();

      * Scenario 4: A simple call  to three threads (including main thread) but with the join() method after initiating
      * every thread, the threads will have to wait for the previous thread to finish its execution, even if it takes
      * time, so order execution is guaranteed.
        Thread thread1 = new Thread(() -> {
            try {
                Test1();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(ThreadExamples::Test2);
        thread1.setName("Thread #1");
        thread2.setName("Thread #2");
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        System.out.println("Executing: " + Thread.currentThread().getName());
    * */

    public static void main(String[] args) throws SQLException, InterruptedException {
        //Method call goes here.
        double start = System.currentTimeMillis();
        evenNumbersSum();
        oddNumbersSum();
        double duration = ((System.currentTimeMillis() - start) / 1000); //remove /1000 for milliseconds.
        System.out.println("Process took: " + duration + " secs.");

        start = System.currentTimeMillis();
        Thread thread1 = new Thread(ThreadExamples::evenNumbersSum);
        Thread thread2 = new Thread(ThreadExamples::oddNumbersSum);
        thread1.setName("Thread #1");
        thread2.setName("Thread #2");
        thread1.start();
        thread2.start();
        duration = ((System.currentTimeMillis() - start) / 1000); //remove /1000 for milliseconds.
        System.out.println("Process took: " + duration + " secs.");
    }

    public static void evenNumbersSum() {
        double sum = 0;

        for (int i = 0; i < 500000000; i++) {
            if (i % 2 == 0) {
                sum = sum + 1;
            }
        }
        System.out.println("Sum of even numbers: " + sum);
    }


    public static void oddNumbersSum() {
        double sum = 0;

        for (int i = 0; i < 500000000; i++) {
            if (i % 2 == 1) {
                sum++;
            }
        }
        System.out.println("Sum of odds numbers: " + sum);
    }

    private static void example1() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                Test1();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(ThreadExamples::Test2);
        thread1.setName("Thread #1");
        thread2.setName("Thread #2");
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        System.out.println("Executing: " + Thread.currentThread().getName());
    }

    private static void example2() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                ThreadDbTest1();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                ThreadDbTest2();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        thread1.setName("Thread #1");
        thread2.setName("Thread #2");
        thread1.start();
        thread1.join();
        thread2.start();
    }

    private static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        return DriverManager.getConnection(MSSQL_CONNECTION_STRING,
                MSSQL_USER_NAME, MSSQL_PASSWORD);
    }

    private static void ThreadDbTest() throws SQLException {
        Connection conn = getConnection();
        conn.setAutoCommit(false);
        String insertStatement = "INSERT INTO THREAD_TEST(DESCRIPTION, CORRELATIVE) VALUES(?, ?)";
        PreparedStatement ps = conn.prepareStatement(insertStatement);
        for (int i = 1; i <= 10000; i++) {
            ps.setString(1, "Inserted from Thread #1.");
            ps.setInt(2, i);
            ps.executeUpdate();
            conn.commit();
        }
        System.out.println("Process finished successfully.");
    }

    private static void ThreadDbTest1() throws SQLException {
        double start = System.currentTimeMillis();
        try {
            Connection conn = getConnection();
            conn.setAutoCommit(false);
            String insertStatement = "INSERT INTO THREAD_TEST(DESCRIPTION, CORRELATIVE) VALUES(?, ?)";
            PreparedStatement ps = conn.prepareStatement(insertStatement);
            for (int i = 1; i <= 5000; i++) {
                ps.setString(1, "Inserted from Thread #1.");
                ps.setInt(2, i);
                ps.executeUpdate();
                conn.commit();
            }
            System.out.println("Process finished successfully.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        double duration = ((System.currentTimeMillis() - start) / 1000); //remove /1000 for milliseconds.
        System.out.println("Process took: " + duration + " secs.");
    }

    private static void ThreadDbTest2() throws SQLException {
        double start = System.currentTimeMillis();
        try {
            Connection conn = getConnection();
            conn.setAutoCommit(false);
            String insertStatement = "INSERT INTO THREAD_TEST(DESCRIPTION, CORRELATIVE) VALUES(?, ?)";
            PreparedStatement ps = conn.prepareStatement(insertStatement);
            for (int i = 5001; i <= 10000; i++) {
                ps.setString(1, "Inserted from Thread #2.");
                ps.setInt(2, i);
                ps.executeUpdate();
                conn.commit();
            }
            System.out.println("Process finished successfully.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        double duration = ((System.currentTimeMillis() - start) / 1000); //remove /1000 for milliseconds.
        System.out.println("Process took: " + duration + " secs.");
    }

    public static void Test1() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Executing: " + Thread.currentThread().getName());
    }

    public static void Test2() {
        // Your Test2() implementation goes here
        System.out.println("Executing: " + Thread.currentThread().getName());
    }
}
