package com.company;

public class TripleAnalyticksGeometry implements Calculative {
    private double z1, z2, x1, x2, y1, y2;

    public TripleAnalyticksGeometry(double x1, double y1, double x2, double y2, double z1, double z2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.z1 = z1;
        this.z2 = z2;
    }

    public double LengthVector(){
        double LengthX = Math.pow((x2 - x1), 2);
        double LengthY = Math.pow((y2 - y1), 2);
        double LengthZ = Math.pow((z2 - z1), 2);
        return Math.sqrt(LengthX + LengthY + LengthZ);
    }

    public double[] CoordinatesVector() {
        double I = x2 - x1;
        double J = y2 - y1;
        double K = z2 - z1;
        final double[] Coordinates = {I, J, K};
        return Coordinates;
    }

    public double CoordinateScalarProductVector() {
        return x1 * x2 + y1 * y2 + z1 * z2;
    }

    public boolean OrthogonalVector() {
        if (CoordinateScalarProductVector() == 0)
            return true;
        else
            return false;
    }

    public boolean OrthogonalVector(double angle) {
        if (angle%90 == 0 && angle%180 != 0)
            return true;
        else
            return false;
    }

    public boolean Complanarity(double x3, double y3, double z3){
        double det = x1 * y2 * z3 + x2 * z1 * y3 + y1 * z2 * x3 - z1 * y2 * x3 - y3 * x1 * z2 - x2 * y1 * z3;
        if (det == 0)
            return true;
        else
            return false;
    }

    public double[] VectorProduct() {
        double[][] Matrix ={{x1, y1, z1},//string collonum
                            {x2, y2, z2}};
        double detX = Matrix[0][1] * Matrix[1][2] - Matrix[1][1] * Matrix[0][2];
        double detY = Matrix[0][0] * Matrix[1][2] - Matrix[1][0] * Matrix[0][2];
        double detZ = Matrix[0][0] * Matrix[1][1] - Matrix[1][0] * Matrix[0][1];
        double[] Coordinates = {detX, detY, detZ};
        return Coordinates;
    }

    public double MixedWork(double x3, double y3, double z3){
        double MixedWork = x1 * y2 * z3 + x2 * z1 * y3 + y1 * z2 * x3 - z1 * y2 * x3 - y3 * x1 * z2 - x2 * y1 * z3;
        return MixedWork;

    }

    public double[] SegmentDivision(double lambda) {
        double CoordinateX = (x1 - lambda * x2) / (1 + lambda);
        double CoordinateY = (y1 - lambda * y2) / (1 + lambda);
        double CoordinateZ = (z1 - lambda * z2) / (1 + lambda);
        final double[] CoordinatesPoint = {CoordinateX, CoordinateY, CoordinateZ};
        return CoordinatesPoint;
    }
}
