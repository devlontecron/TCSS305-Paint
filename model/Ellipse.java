/**
 * TCSS 305 � Autumn 2015 Assignment 5.2
 * 
 * the class that handles and draws the ellipse shape.
 * 
 * @author Devin Durham
 * @version 50 Nov 2015
 */
package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 * Builds the Rectangle shape.
 * 
 * @author Devin Durham
 * @version 50
 */
public class Ellipse extends AbstractShapes {

    /**
     * 
     * @param theColor 
     * @param theWidth 
     * @param theStartX 
     * @param theStartY 
     * @param theEndX 
     * @param theEndY 
     */
    public Ellipse(final Color theColor, final int theWidth, final double theStartX,
                   final double theStartY, final double theEndX, final double theEndY) {
        super(theColor, theWidth, theStartX, theStartY, theEndX, theEndY);
    }

    @Override
    public void draw(final Graphics theGraphics) {
        super.draw(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;

        // for better graphics display
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);

        final double startY = myStartY > myEndY ? myEndY : myStartY;
        final double start = myStartX > myEndX ? myEndX : myStartX;
        final Shape ellipse = new Ellipse2D.Double(start, startY, Math.abs(myEndX - myStartX),
                                                   Math.abs(myEndY - myStartY));

        g2d.setPaint(myColor);
        g2d.setStroke(new BasicStroke(myWidth));
        g2d.draw(ellipse);

    }

}
