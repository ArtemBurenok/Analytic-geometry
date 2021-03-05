package sample;

public class DoubleAnalyticsGeometry implements Calculative{
    private double x1, y1;
    private double x2, y2;
    //Constructor
    public DoubleAnalyticsGeometry(double x1, double y1, double x2, double y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
   @Override
    public double LengthVector(){
        double LengthX = Math.pow((x2 - x1), 2);
        double LengthY = Math.pow((y2 - y1), 2);
        return Math.sqrt(LengthX + LengthY);
    }

    @Override
    public double[] CoordinatesVector(){
        double I = x2 - x1;
        double J = y2 - y1;
        final double[] Coordinates = {I, J};
        return Coordinates;
    }

    @Override
    public double CoordinateScalarProductVector(){
        return x1 * x2 + y1 * y2;
    }

    @Override
    public boolean OrthogonalVector(){
        if (CoordinateScalarProductVector() == 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean Collinearity(){
        double[][] Matrix = {{x1, x2},
                {y1, y2}};
        double det = Matrix[0][0] * Matrix[1][1] - Matrix[0][1] * Matrix[1][0];
        if(det == 0)
            return true;
        else
            return false;
    }

    @Override
    public double[] SegmentDivision(double lambda) {
        double CoordinateX = (x1 - lambda * x2) / (1 + lambda);
        double CoordinateY = (y1 - lambda * y2) / (1 + lambda);
        final double[] CoordinatesPoint = {CoordinateX, CoordinateY};
        return CoordinatesPoint;
    }
}
