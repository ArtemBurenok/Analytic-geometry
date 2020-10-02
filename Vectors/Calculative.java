package com.company;

public interface Calculative {
    public double LengthVector();
    public double[] CoordinatesVector();
    public double CoordinateScalarProductVector();
    public boolean OrthogonalVector(double angle);
    public boolean OrthogonalVector();
    public double[] SegmentDivision(double lambda);

}
