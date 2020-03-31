public class NBody{
    public static double readRadius (String path){
        In in = new In(path);
        in.readInt();
        double r = in.readDouble();
        return r;
    }

    public static Body[] readBodies (String path){
        In in = new In(path);
        int len = in.readInt();
        in.readDouble();
        Body[] res = new Body[len];
        double xP = 0;
        double yP = 0;
        double xV = 0;
        double yV = 0;
        double m = 0;
        String img = "";
        for(int i=0;i<len;i++){
                xP = in.readDouble();
                yP = in.readDouble();
                xV = in.readDouble();
                yV = in.readDouble();
                m = in.readDouble();
                img = in.readString();
            res[i] = new Body(xP, yP, xV, yV, m, img);
        }
        return res;
    }

    public static void main(String[] args){
        double t = 0;
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);

        String filename = args[2];
        double ur = NBody.readRadius(filename);
        Body[] bodies = NBody.readBodies(filename);
        int len = bodies.length;

        StdDraw.setScale(-ur, ur);
        StdDraw.enableDoubleBuffering();

        StdDraw.picture(0, 0,"images/starfield.jpg");

        for (int i=0;i<len;i++){
            bodies[i].draw();
        }

        while(t <= T){
            double[] xForces = new double[len];
            double[] yForces = new double[len];
            for (int i=0;i<len;i++){
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
            }
            for (int i=0;i<len;i++){
                bodies[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0,"images/starfield.jpg");
            for (int i=0;i<len;i++){
                bodies[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10); 
            t += dt;
        }
        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", ur);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                          bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
        }
    }
}