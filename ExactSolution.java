public class ExactSolution {
    public ProblemData problemData;
    ExactSolution(ProblemData problemData)
    {
        this.problemData=problemData;
    }

    /*public void solveExact() throws GRBException {

        GRBEnv env = new GRBEnv("knapsack.log");
        GRBModel model = new GRBModel(env);
        int n=this.problemData.item.length;

        GRBVar[] x = new GRBVar[n];
        for(int i=0;i<n;i++)
        {
            x[i]=model.addVar(0,1,0,GRB.BINARY,"x_"+this.problemData.item[i].getId());

        }
        for(int i=0;i<n;i++){
            System.out.println( x[i]);
        }


        GRBLinExpr expr = new GRBLinExpr();
        for(int i=0;i<n;i++)
        {
            expr.addTerm(this.problemData.item[i].getWeight(), x[i]);

        }
        model.addConstr(expr, GRB.LESS_EQUAL, this.problemData.knapsackCapacity , "Knapsack Contraint");

        GRBLinExpr exprObj = new GRBLinExpr();
        for(int i=0;i<n;i++)
        {
            exprObj.addTerm(this.problemData.item[i].getValue(),x[i]);
        }
        model.setObjective(exprObj,GRB.MAXIMIZE);

        //model.setObjective(expr,GRB.MINIMIZE);

        model.write("knapsack.lp");
        model.optimize(); //print these

//			System.out.println("Optimal value of 643 "+x[4].get(GRB.DoubleAttr.X));
//			System.out.println("Optimal value of 7373 "+x[5].get(GRB.DoubleAttr.X));
//			System.out.println("Optimal value of 7646 "+x[6].get(GRB.DoubleAttr.X));
//			System.out.println("Optimal value of 7566 "+x[7].get(GRB.DoubleAttr.X));
//            System.out.println("exprObj values are "+exprObj.getValue());


        for(int i=0;i<n;i++) {
            if (x[i].get(GRB.DoubleAttr.X) == 1)
                System.out.println(x[i].index());

        }


        model.dispose();
        env.dispose();

    }*/

}
