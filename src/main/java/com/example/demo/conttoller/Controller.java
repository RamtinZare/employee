package com.example.demo.conttoller;

import com.example.demo.entity.DataPerson;
import com.example.demo.repository.MyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controller {
   // @Autowired     //fieldInjection
    private final MyRepository myRepository;

    //ConstructorInjection
    public Controller(MyRepository myRepository) {

        this.myRepository = myRepository;
    }



    @PostMapping("/post")
    public ResponseEntity<?> createMember(@RequestBody DataPerson dataPerson)
    {
            DataPerson save = myRepository.save(dataPerson);
            return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> searching(@PathVariable("id") Long id){
        Optional<DataPerson> mydata= myRepository.findById(id);
        if (mydata.isPresent())
        {
            return new ResponseEntity<>(mydata.get(),HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("not found this id"+id,HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/foundAll")
    public ResponseEntity<?> searchAll()
    {
        List<DataPerson> dataPeople= (List<DataPerson>) myRepository.findAll();
        if (dataPeople.size()>0)
        {
            return new ResponseEntity<>(dataPeople,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("not found id",HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable("id") Long id,@RequestBody DataPerson dataPerson)
    {
        Optional<DataPerson> dataPerson1=myRepository.findById(id);
        if (dataPerson1.isPresent())
        {
            DataPerson dataPerson2= dataPerson1.get();
            dataPerson2.setId(dataPerson.getId() != null ? dataPerson.getId() : dataPerson2.getId() );
            dataPerson2.setFirstName(dataPerson.getFirstName() != null ? dataPerson.getFirstName() : dataPerson2.getFirstName());
            dataPerson2.setLastName(dataPerson.getLastName() != null ? dataPerson.getLastName() : dataPerson2.getLastName());
            return new ResponseEntity<>(dataPerson2,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("id person not found"+id , HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delet/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id)
    {
        try {
            myRepository.deleteById(id);
            return new ResponseEntity<>("person is deleted"+id,HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("id not found" +id,HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("/deleteAll")
    private ResponseEntity<?> deleteAll()
    {
        try {
            myRepository.deleteAll();
            return new ResponseEntity<>("all id is delete",HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("not id is found",HttpStatus.NOT_FOUND);
        }
    }





}
