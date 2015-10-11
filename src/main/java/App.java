import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("clients", Client.all());
      model.put("hairdressers", Hairdresser.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/admin", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("clients", Client.all());
      model.put("hairdressers", Hairdresser.all());
      model.put("template", "templates/admin.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("add", (request, response) -> {
   HashMap<String, Object> model = new HashMap<String,Object>();
   String name = request.queryParams("name");
   Hairdresser newHairdresser = new Hairdresser(name);
   newHairdresser.save();
   model.put("hairdresser", Hairdresser.all());
   model.put("template", "templates/admin.vtl");
   return new ModelAndView(model, layout);
 }, new VelocityTemplateEngine());

 post("add-client", (request, response) -> {
   HashMap<String, Object> model = new HashMap<String,Object>();
   Hairdresser hairdresser = Hairdresser.find(Integer.parseInt(request.queryParams("hairdresser_id")));
   String clientName = request.queryParams("client_name");
   String address = request.queryParams("address");
   String phone = request.queryParams("phone");

   Client client = new Client(clientName, hairdresser.getId());
   client.save();

   model.put("client", client);
   model.put("hairdressers", Hairdresser.all());
   model.put("template", "templates/admin.vtl");
   return new ModelAndView(model, layout);
 }, new VelocityTemplateEngine());

 get("/hairdressers/:id/update", (request, response) -> {
   HashMap<String, Object> model = new HashMap<String, Object>();
   Hairdresser hairdresser = Hairdresser.find(Integer.parseInt(request.params(":id")));
   model.put("hairdresser", hairdresser);
   model.put("template", "templates/hairdresser-form.vtl");
   return new ModelAndView(model, layout);
 }, new VelocityTemplateEngine());

 post("/hairdressers/:id/update", (request, response) -> {
   HashMap<String, Object> model = new HashMap<String, Object>();
   Hairdresser hairdresser = Hairdresser.find(Integer.parseInt(request.params(":id")));
   String name = request.queryParams("name");
   hairdresser.update(name);
   response.redirect("/");
   return null;
 });

 get("/:hairdresser_id/clients/:id/update", (request, response) -> {
   HashMap<String, Object> model = new HashMap<String, Object>();
   Hairdresser hairdresser = Hairdresser.find(Integer.parseInt(request.params(":hairdresser_id")));
   Client client = Client.find(Integer.parseInt(request.params(":id")));
   model.put("hairdresser", hairdresser);
   model.put("hairdressers", Hairdresser.all());
   model.put("client", client);
   model.put("template", "templates/client-form.vtl");
   return new ModelAndView(model, layout);
 }, new VelocityTemplateEngine());

 // post("/:hairdresser_id/clients/:id/update", (request, response) -> {
 //   HashMap<String, Object> model = new HashMap<String, Object>();
 //   Hairdresser hairdresser = Hairdresser.find(Integer.parseInt(request.params(":hairdresser_id")));
 //   Client client = Client.find(Integer.parseInt(request.params(":id")));
 //   model.put("hairdressers", Hairdresser.all());
 //   String client_name = request.queryParams("client_name");
 //   String address = request.queryParams("address");
 //   String phone = request.queryParams("phone");
 //   client.update(client_name, address, phone);
 //   response.redirect("/");
 //   return null;
 // });

 // post("/:hairdresser_id/clients/:id/delete", (request, response) -> {
 //   HashMap<String, Object> model = new HashMap<String, Object>();
 //   Hairdresser hairdresser = Hairdresser.find(Integer.parseInt(request.params(":hairdresser_id")));
 //   Client client = Client.find(Integer.parseInt(request.params(":id")));
 //   model.put("template","templates/index.vtl");
 //   client.delete();
 //   response.redirect("/");
 //   return null;
 // });

  }
}
