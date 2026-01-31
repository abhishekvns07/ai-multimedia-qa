package com.example.aiqa.model;

public class TranscriptSegment {

    private String text;
    private double start;
    private double end;

    public TranscriptSegment() {}

    public TranscriptSegment(String text, double start, double end) {
        this.text = text;
        this.start = start;
        this.end = end;
    }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public double getStart() { return start; }
    public void setStart(double start) { this.start = start; }

    public double getEnd() { return end; }
    public void setEnd(double end) { this.end = end; }
}
