package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static spark.Spark.*;

public class Main {
    static int cont = 0;
    public static void main(String[] args) {

        port(8080);


        JFrame frame = new JFrame("Cliente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JTextField imputField1 = new JTextField();
        JTextField outputField = new JTextField();
        outputField.setEditable(false);

        imputField1.setFont((new Font("Arial", Font.PLAIN, 30)));
        outputField.setFont((new Font("Arial", Font.PLAIN, 30)));

        JLabel label1 = new JLabel("Nome: ");
        label1.setFont((new Font("Arial", Font.BOLD, 30)));
        JLabel label3 = ((new JLabel("Acesso: ")));
        label3.setFont((new Font("Arial", Font.BOLD, 30)));

        panel.add(label1);
        panel.add(imputField1);
        panel.add(label3);
        panel.add(outputField);

        frame.add(panel);
        frame.setVisible(true);

        String[] buttonLabels = {
                "Enviar"
        };

        get("/nome/:p", (req, res) -> {
            String op1 = req.params("p");
            imputField1.setText(op1);
            cont++;
            outputField.setText((Integer.toString(cont)));

            return "Acesso: " + cont;
        });
    }
}