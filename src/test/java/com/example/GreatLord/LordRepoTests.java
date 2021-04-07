package com.example.GreatLord;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.example.GreatLord.model.Lord;
import com.example.GreatLord.repository.LordRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LordRepoTests {
    @Autowired
    private LordRepo lordRepo;

    @Test
    public void testSaveLord() {
        Lord lord = new Lord(16L,"Вельзевул", 700);
        lordRepo.save(lord);
        Optional<Lord> lord1 = lordRepo.findById(16L);
        System.out.println(lord1.get().toString());
        assertNotNull(lord1.get());
        assertEquals(lord.getId(),lord1.get().getId());
        assertEquals(lord.getName(),lord1.get().getName());
        assertEquals(lord.getAge(),lord1.get().getAge());
    }
    @Test
    public void testFindTop10YoungestLords() {
        List<Lord> lords = new ArrayList<>();
        lords.add(new Lord(1L,"Абрам",100));
        lords.add(new Lord(4L,"Авдей",200));
        lords.add(new Lord(2L,"Аваз",300));
        lords.add(new Lord(5L,"Автандил",400));
        lords.add(new Lord(8L,"Адриан",500));
        lords.add(new Lord(3L,"Август",600));
        lords.add(new Lord(7L,"Адис",700));
        lords.add(new Lord(12L,"Альфред",800));
        lords.add(new Lord(6L,"Адам",900));
        lords.add(new Lord(11L,"Альберт",1000));
        List <Lord> lords1 = lordRepo.findTop10ByOrderByAgeAsc();
        assertEquals(lords,lords1);
    }
    @Test
    public void testFindSlackerLords(){
        List<Lord> lords = new ArrayList<>();
        lords.add(new Lord(3L,"Август",600));
        lords.add(new Lord(4L,"Авдей",200));
        lords.add(new Lord(5L,"Автандил",400));
        lords.add(new Lord(6L,"Адам",900));
        lords.add(new Lord(7L,"Адис",700));
        lords.add(new Lord(8L,"Адриан",500));
        lords.add(new Lord(9L,"Азарий",5419));
        lords.add(new Lord(10L,"Аким",5000));
        lords.add(new Lord(11L,"Альберт",1000));
        lords.add(new Lord(12L,"Альфред",800));
        List<Lord> lords1 = lordRepo.findSlackerLords();
        assertEquals(lords, lords1);
    }
}
