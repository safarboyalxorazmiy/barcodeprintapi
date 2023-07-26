package com.fridge.printer;

import com.fridge.printer.dto.PrintRequestDTO;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

@Service
public class PrinterService {

//    public String print (PrintRequestDTO requestDTO) {
//        if (requestDTO.getPassword().equals("Grechka4kg$")) {
//            try {
//                String command = "java BarTenderPrintExample.java";
//
//                // Get the Runtime instance
//                Runtime runtime = Runtime.getRuntime();
//
//                // Start the process
//                Process process = runtime.exec(command);
//                System.out.println(process.info());
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//            return "Done!";
//        }
//        return "Something wrong!";
//    }


   public String print(PrintRequestDTO requestDTO) {
        if (requestDTO.getPassword().equals("Grechka4kg$")) {
            try {
                String bartenderExePath = "C:/Program Files/Seagull/BarTender 2019/bartend.exe";
                String btwFilePath = "C:/Users/lenovo/Desktop/serial211n1.btw";

                String[] command = { bartenderExePath, "/F=\"" + btwFilePath + "\""}; // {, "/P"}

                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

                int centerX = screenSize.width / 2;
                int centerY = screenSize.height / 2;

                Robot robot = new Robot();

                robot.mouseMove(centerX, centerY);

                Thread.sleep(3000);

                ProcessBuilder processBuilder = new ProcessBuilder(command);
                Process process = processBuilder.start();

                Thread.sleep(1000);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

                robot.keyPress(KeyEvent.VK_F11);

                robot.keyRelease(KeyEvent.VK_F11);

                Thread.sleep(1000);

                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

                System.out.println("clicked");

                Thread.sleep(100);

                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

                Thread.sleep(100);

                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_A);
                robot.keyRelease(KeyEvent.VK_A);
                robot.keyRelease(KeyEvent.VK_CONTROL);

                Thread.sleep(100);


                robot.keyPress(KeyEvent.VK_BACK_SPACE);
                robot.keyRelease(KeyEvent.VK_BACK_SPACE);

                Thread.sleep(1000);

                typeString(robot, String.valueOf(requestDTO.getOrderId()));

                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);


                Thread.sleep(1000);

                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_P);
                robot.keyRelease(KeyEvent.VK_P);
                robot.keyRelease(KeyEvent.VK_CONTROL);


                robot.keyPress(KeyEvent.VK_BACK_SPACE);
                robot.keyRelease(KeyEvent.VK_BACK_SPACE);

                typeString(robot, String.valueOf(1));

                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);

                Thread.sleep(1000);

                robot.keyPress(KeyEvent.VK_ALT);
                robot.keyPress(KeyEvent.VK_F4);
                robot.keyRelease(KeyEvent.VK_F4);
                robot.keyRelease(KeyEvent.VK_ALT);

                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);


                int exitCode = process.waitFor();
                if (exitCode == 0) {
                    System.out.println("Print successful!");
                } else {
                    System.err.println("Print failed!");
                }
            }
            catch (IOException | InterruptedException | AWTException ignored) {}
        }

        return "DONE";
    }

    private static void typeString(Robot robot, String s) {
        for (char c : s.toCharArray()) {
            typeCharacter(robot, c);
        }
    }

    private static void typeCharacter(Robot robot, char c) {
        switch (c) {
            case '0' -> typeKey(robot, KeyEvent.VK_0);
            case '1' -> typeKey(robot, KeyEvent.VK_1);
            case '2' -> typeKey(robot, KeyEvent.VK_2);
            case '3' -> typeKey(robot, KeyEvent.VK_3);
            case '4' -> typeKey(robot, KeyEvent.VK_4);
            case '5' -> typeKey(robot, KeyEvent.VK_5);
            case '6' -> typeKey(robot, KeyEvent.VK_6);
            case '7' -> typeKey(robot, KeyEvent.VK_7);
            case '8' -> typeKey(robot, KeyEvent.VK_8);
            case '9' -> typeKey(robot, KeyEvent.VK_9);
            default -> {}
        }
    }

    private static void typeKey(Robot robot, int keyEvent) {
        robot.keyPress(keyEvent);
        robot.keyRelease(keyEvent);
    }
}