package com.raven.bar.blankchart;

import java.awt.Graphics2D;

public abstract class BlankPlotBarChatRender {

    public abstract String getLabelText(int index);

    public abstract void renderSeries(BlankPlotBarChart chart, Graphics2D g2, BarSeriesSize size, int index);
}
