package com.example.event.Controller;


import com.example.event.ApiResponse.ApiResponse;
import com.example.event.Model.events;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/events")
public class EventsController {

    ArrayList<events>eventss=new ArrayList<>();


    @PostMapping("/add")
    public ApiResponse add(@RequestBody events event){
        eventss.add(event);
        return new ApiResponse("added");
    }


@GetMapping("/display")
    public ArrayList display(){
        return eventss;
    }

    @PutMapping("update/{index}")
    public ApiResponse update(@PathVariable int index,@RequestBody events event){
        eventss.set(index,event);
        return new ApiResponse("updated");
    }

    @DeleteMapping("/delete/{index}")

    public ApiResponse delete(@PathVariable int index){
       eventss.remove(index);
       return new ApiResponse("delted");
    }


    @PutMapping("/change/{id}/{capacity}")

    public ApiResponse chang(@PathVariable int id ,@PathVariable int capacity){
        for (events event:eventss){
            if(event.getId()==id){
                event.setCapacity(capacity);
            }
        }
        return new ApiResponse("changed");
    }
@GetMapping("search/{id}")
    public String search(@PathVariable int id){
        for (events e:eventss){
            if(e.getId()==id){
                return e.toString();
            }
        }
        return "not Found";
    }



}
