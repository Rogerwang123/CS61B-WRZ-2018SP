public class NBody {

    public static double readRadius(String Address){
        In in = new In(Address);
        int Planetnum = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String Address) {
        In in = new In(Address);
        int Planetnum = in.readInt();
        double radius = in.readDouble();
        Planet[] Planets = new Planet[Planetnum];
        for (int n = 0; n < Planetnum; n++) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            Planets[n] =new Planet(xP, yP, xV, yV, m, img);
        }

        return Planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] Planets = readPlanets(filename);
        double Radius = readRadius(filename);


        StdDraw.setXscale(-Radius, Radius);
        StdDraw.setYscale(-Radius, Radius);
        StdDraw.enableDoubleBuffering();



        double t = 0;
        int num = Planets.length;
        while(t < T) {
            double[] xForces = new double[num];
            double[] yForces = new double[num];
            for (int n = 0; n < num; n++) {
                xForces[n] = Planets[n].calcNetForceExertedByX(Planets);
                yForces[n] = Planets[n].calcNetForceExertedByY(Planets);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (int n = 0; n < num; n++) {
                Planets[n].update(dt, xForces[n], yForces[n]);
                Planets[n].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            t += dt;
        }
        StdOut.printf("%d\n", Planets.length);
        StdOut.printf("%.2e\n", Radius);
        for (int i = 0; i < Planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    Planets[i].xxPos, Planets[i].yyPos, Planets[i].xxVel,
                    Planets[i].yyVel, Planets[i].mass, Planets[i].imgFileName);
        }
    }


}
