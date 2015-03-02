/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

/**
 *
 * @author student
 */
public class Question {

    public String question;
    public boolean answer;
    public boolean used;

   public Question(String Vraag, boolean Antwoord, boolean used) {
        this.question = Vraag;
        this.answer = Antwoord;
        this.used = used;
    }
}
