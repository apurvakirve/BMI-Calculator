package apurvakirve;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/BmiCalculatorServlet")
public class BmiCalculatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BmiCalculatorServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
    	PrintWriter pw=response.getWriter();
         
         try {
             double weight = Double.parseDouble(request.getParameter("weight").trim());
             double height = Double.parseDouble(request.getParameter("height").trim()) / 100; // convert cm to meters
             int age = Integer.parseInt(request.getParameter("age").trim());
             String gender = request.getParameter("gender");

             double bmi = weight / (height * height);
             String classification = "";

             if (bmi < 18.5) {
                 classification = "Underweight. "
                 		+ "1. Have a healthy protein and Carb rich diet."
                		+ "2. TO STAY HEALTHY FOLLOW MY YOUTUBE CHANNEL";
                		 
             } else if (bmi >= 18.5 && bmi < 24.9) {
                 classification = "Normal weight. "
                 		+ "1. Congratulation. Be consistant."
                		+ "2. TO STAY HEALTHY FOLLOW MY YOUTUBE CHANNEL";

             } else if (bmi >= 25 && bmi < 29.9) {
                 classification = "Overweight."
                 		+   "1. Avoid junk food, as it has high sodium content"
                		+   "2. TO STAY HEALTHY FOLLOW MY YOUTUBE CHANNEL ";

             } else {
                 classification = "Obese. "
                 		+ "1. More attention is required."
                		+ "2. TO STAY HEALTHY FOLLOW MY YOUTUBE CHANNEL";
             }

             pw.println("<html><head><style>");
             pw.println(".result-container { display: flex; justify-content: center; align-items: center; height: 100vh; background: url('motiv1.jpg') no-repeat center center fixed; background-size: cover; }");
             pw.println(".result-card { background: rgba(0, 0, 0, 0.7); padding: 20px; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); width: 300px; text-align: center; color: white; }");
             pw.println("</style></head><body>");
             pw.println("<div class='result-container'><div class='result-card'>");
             pw.println("<h2>BMI Calculator Result</h2>");
             pw.println("<p>Weight: " + weight + " kg</p>");
             pw.println("<p>Height: " + (height * 100) + " cm</p>");
             pw.println("<p>Age: " + age + " years</p>");
             pw.println("<p>Gender: " + gender + "</p>");
             pw.println("<h3>Your BMI is: " + bmi + "</h3>");
             pw.println("<h3>Classification: " + classification + "</h3>");
             pw.println("</div></div>");
             pw.println("</body></html>");
         } catch (NumberFormatException e) {
             pw.println("<html><body>");
             pw.println("<h2>Error</h2>");
             pw.println("<p>Invalid input. Please enter valid numbers for weight, height, and age.</p>");
             pw.println("</body></html>");
         }
     }

    
    	    

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
