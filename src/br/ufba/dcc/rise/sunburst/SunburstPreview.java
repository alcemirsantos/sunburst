package br.ufba.dcc.rise.sunburst;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import br.ufba.dcc.rise.sunburst.factory.FMFactory;
import br.ufba.dcc.rise.sunburst.model.Feature;
import br.ufba.dcc.rise.sunburst.model.Leaf;
import br.ufba.dcc.rise.sunburst.model.RSFArc;
import br.ufba.dcc.rise.sunburst.model.RSFFeatureModel;

public class SunburstPreview {

	/**
	 * The application entry point
	 * 
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		new SunburstPreview().run();
	}

	/**
	 * Runs the application
	 */
	public void run() {
		Display display = new Display();
		Shell shell = new Shell(display);

		shell.addListener(SWT.Paint, new SunBurstExampleListener());

		shell.setText("SunBurst Example");
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	class SunBurstExampleListener implements Listener {
		RSFFeatureModel model = new RSFFeatureModel(
				FMFactory.createFeatureModelSample(3));

		int r = 50;
		int width = r;
		int height = r;
		int begin = 0;

		@Override
		public void handleEvent(Event e) {

			// Get the canvas for drawing and its dimensions
			Canvas canvas = (Canvas) e.widget;
			int canvasWidth = canvas.getBounds().width;
			int canvasHeight = canvas.getBounds().height;
			int x = (canvasWidth - width) / 2; // needed to draw in the center
			int y = (canvasHeight - height) / 2; // needed to draw in the center

			// Set the drawing color to black
			e.gc.setBackground(e.display.getSystemColor(SWT.COLOR_BLACK));

			// Draw the arc, centered on the canvas
			drawSunburst(model.getArcTree(), e, x, y, r, r, 0,360);
		}

		private void drawSunburst(RSFArc arc, Event e, int x, int y,
				int w, int h, int start, int end) {
			e.gc.drawArc(x, y, w, h, start, end);
			
			
			Feature f = arc.getFeature();
			int numChildren = f.getChildren().size();
			if (numChildren == 0){
				return;
			}
			int fatherAngle = end-start;
			if(fatherAngle!=360){
				e.gc.drawLine(x+(w/2), y, x+(w/2)+(r/2), y+(r/2));
				e.gc.drawLine(y+(h/2), x, y+(h/2)+(r/2), x+(r/2));
			}
			int increment = fatherAngle/numChildren;
			
			end = start;
			end = normalize(end);				
			for (Leaf l : arc.getChildren()) {
				RSFArc nextArc = (RSFArc) l;
				end += increment;
				normalize(end);
				drawSunburst(nextArc, e, x - (r / 2), y - (r / 2), w + r,
						h + r,  start, end);
				start = end;
			}
		}

		/**
		 * avoids angle greater than 360 degrees.
		 * 
		 * @param angle
		 * @return
		 */
		private int normalize(int angle){
			if (angle<0){
				return normalize(-1*angle);
			}
			if (angle>360) {
				return angle-360;
			}
			return angle;
		}
	}

}// end of the preview
