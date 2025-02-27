/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsukses.Implements;

import java.util.List;
import projectsukses.Models.*;
/**
 *
 * @author ACER NITRO
 */
public interface DataImplement {
    public void insert(DataFinance p);
    public void update(DataFinance p);
    public void delete(int id_datauser);
    public List<DataFinance> getAll();
}
