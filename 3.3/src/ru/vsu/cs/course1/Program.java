package ru.vsu.cs.course1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException {
                    java.awt.EventQueue.invokeLater(() -> {
                        try {
                            new FormMain().setVisible(true);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                }
            }


