package com.example.projecttrucker.ProjectController;

import com.example.projecttrucker.ApiResponse.ApiResponse;
import com.example.projecttrucker.Model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

    ArrayList<Project> projects=new ArrayList<>();




    @PostMapping("/add")
   public ApiResponse add(@RequestBody Project project){
        projects.add(project);
        return new ApiResponse("added");
    }
   @GetMapping("/display")
  public ArrayList<Project> display(){
       return projects;
    }

    @PutMapping("/update/{index}")
    public ApiResponse update(@PathVariable int index, @RequestBody Project project){
               projects.set(index,project);
           return new ApiResponse("Updated");
       }

       @DeleteMapping("/delete/{index}")

       public ApiResponse delete(@PathVariable int index){

               projects.remove(index);

       return new ApiResponse("deleted");
       }

       @PutMapping("/change/status/{index}")

       public String status(@PathVariable int index){
                   if (projects.get(index).getStatus().equalsIgnoreCase("Done")){
                       projects.get(index).setStatus("Not Done");
                   return "Not Done";}
           else if(projects.get(index).getStatus().equalsIgnoreCase("Not Done"))
                       projects.get(index).setStatus("Done");
                   return "Done";
               }



       @GetMapping("/search/{title}")

       public String search(@PathVariable String title){
        for (Project p:projects){
            if(p.getTitl().equalsIgnoreCase(title)){
                return p.toString();
            }
        }
        return "not found";
       }


       @GetMapping("projects/{compnyName}")

       public List compny(@PathVariable String compnyName){
           ArrayList<Project> Projectscompny=new ArrayList<>();
        for(Project p:projects){
           if(p.getCompanyName().equalsIgnoreCase(compnyName)){
               Projectscompny.add(p);
           }
        }
        return Projectscompny;
       }










}
