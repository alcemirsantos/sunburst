package br.ufba.dcc.rise.sunburst;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class Figures {

public static void main(String[] args) {

    final Display display = new Display();

    final Color blue =  new Color(display, 0,0,255);
    final Color black =  new Color(display, 0,0,0);

    final Shell shell = new Shell(display);

    shell.addListener(SWT.Paint, new Listener() {

        public void handleEvent(Event event) {

            GC gc = event.gc;

            int x = 100;
            int y = 100;
            int width = 100;
            int height = 100;
            
//            gc.drawOval(x, y, width, height);
            gc.setLineWidth(2);
            gc.setForeground(black);
            gc.drawArc(x, y, width, height, 0, 90);
            gc.setForeground(blue);
            gc.drawArc(x+10, y+20, width-20, height-20, 0, 90);

        }});

    shell.setText("Figures");
    shell.setSize(500, 450);
    shell.open();

    while (!shell.isDisposed()) {
        if (!display.readAndDispatch())
            display.sleep();
    }

    black.dispose();
    display.dispose();

}}