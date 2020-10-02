package com.company;

public class DoubleAnalyticksGeometry implements Calculative {

    private double x1, y1;
    private double x2, y2;
    //Constructor
    public DoubleAnalyticksGeometry(double x1, double y1, double x2, double y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    //The length of the vector connecting the points
    public double LengthVector(){
        double LengthX = Math.pow((x2 - x1), 2);
        double LengthY = Math.pow((y2 - y1), 2);
        return Math.sqrt(LengthX + LengthY);
    }

    //Vector coordinates
    public double[] CoordinatesVector(){
        double I = x2 - x1;
        double J = y2 - y1;
        final double[] Coordinates = {I, J};
        return Coordinates;
    }
    //Scalar Product
    public double ScalarProductVector(double angle, double Length1, double Length2){
        if (angle ==90)
            return 0;
        else
            return Length1 * Length2 * Math.cos(Math.toRadians(angle));
    }

    public double CoordinateScalarProductVector(){
        return x1 * x2 + y1 * y2;
    }
    //Perpendicular
    public boolean OrthogonalVector(){
        if (CoordinateScalarProductVector() == 0)
            return true;
        else
            return false;
    }

    public boolean OrthogonalVector(double angle){
        if ((angle%90==0) && (angle%180!=0))
            return true;
        else
            return false;
    }

    //Сollinearity
    public boolean Collinearity(){
        double[][] Matrix = {{x1, x2},
                             {y1, y2}};
        double det = Matrix[0][0] * Matrix[1][1] - Matrix[0][1] * Matrix[1][0];
        if(det == 0)
            return true;
        else
            return false;
    }
    //Векторное произведение
    public double VectorProduct(double Length1, double Length2, double angle){
        if((angle%180 == 0))
            return 0;
        else
            return Length1 * Length2 * Math.sin(Math.toRadians(angle));
    }

    @Override
    public double[] SegmentDivision(double lambda) {
        double CoordinateX = (x1 - lambda * x2) / (1 + lambda);
        double CoordinateY = (y1 - lambda * y2) / (1 + lambda);
        final double[] CoordinatesPoint = {CoordinateX, CoordinateY};
        return CoordinatesPoint;
    }
}
