public class Planet {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public static double G = 6.67e-11;
    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;

    }
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double dx = p.xxPos - xxPos;
        double dy = p.yyPos - yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Planet p) {
        // F = G * m * mp / r2
        return G * mass * p.mass / (calcDistance(p) * calcDistance(p));
    }

    public double calcForceExertedByX(Planet p) {
        // Fx = F * dx / r
        return calcForceExertedBy(p) * (p.xxPos - xxPos) / calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        // Fy = F * dx / r
        return calcForceExertedBy(p) * (p.yyPos - yyPos) / calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] Planets){
        double netx = 0;
        for (Planet p : Planets) {
            if (this.equals(p)) {
                continue;
            }
            netx += calcForceExertedByX(p);
        }
        return netx;
    }
    public double calcNetForceExertedByY(Planet[] Planets){
        double nety = 0;
        for (Planet p : Planets) {
            if (this.equals(p)) {
                continue;
            }
            nety += calcForceExertedByY(p);
        }
        return nety;
    }

    public void update(double dt, double fX, double fY) {
        double ax = fX / mass;
        double ay = fY / mass;
        xxVel += ax * dt;
        yyVel += ay * dt;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;

    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }

}
