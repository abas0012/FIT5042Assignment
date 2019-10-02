/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assign.repositories;

import fit5042.assign.repository.entities.ClassSession;
import fit5042.assign.repository.entities.User;
import java.util.List;
import java.util.Set;
import javax.ejb.Remote;

/**
 *
 * @author Adhi Baskoro
 */
@Remote
public interface ClassSessionRepository {

    public void addClassSession(ClassSession classSession) throws Exception;
    
    public ClassSession searchClassSessionById(int id) throws Exception;
    
    public List<ClassSession> getAllClassSessions() throws Exception;
    
    public List<User> getAllUsers() throws Exception;
    
    /**
     * Remove the classSession, whose property ID matches the one being passed as
     * parameter, from the repository
     *
     * @param classSessionId - the ID of the classSession to remove
     */
    public void removeClassSession(int classSessionId) throws Exception;

    /**
     * Update a classSession in the repository
     *
     * @param classSession - the updated information regarding a property
     */
    public void editClassSession(ClassSession classSession) throws Exception;
    
}
