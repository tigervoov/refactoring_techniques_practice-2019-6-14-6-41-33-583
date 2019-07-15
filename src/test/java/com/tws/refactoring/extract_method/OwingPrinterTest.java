package com.tws.refactoring.extract_method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OwingPrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void printOwing() {
//        System.out.print("hello");
//        assertEquals("hello", outContent.toString());
        Order orderOne=new Order(1.0);
        Order orderTwo=new Order(2.0);
        List<Order> orderList=new ArrayList<>();
        orderList.add(orderOne);
        orderList.add(orderTwo);
        OwingPrinter owingPrinter=new OwingPrinter();
        owingPrinter.printOwing("mike",orderList);
        assertEquals("*****************************\r\n" +
                "****** Customer totals ******\r\n"+"*****************************\r\n"+
                "name: mike\r\n"+"amount: 3.0\r\n",outContent.toString()
        );

    }
}