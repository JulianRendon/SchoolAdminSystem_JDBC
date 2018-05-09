/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceDAO;

import java.util.List;
import model.Marks;

/**
 *
 * @author Julian
 */
public interface MarksDAO {

    void create(Marks mk);

    List<Marks> findById(int courseId);

    List<Marks> findAll();

}
