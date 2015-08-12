/*
Elisha David Ugela
 */
package bankaccount;

/**
 *
 * @author jackm_000
 */
public class Interest implements Runnable {
    private Menu menu;
    
    @Override
    public void run() {
        System.out.println("Interest paid");
        menu.payInterest();
    }
    
    public void setMenu(Menu m) {
        this.menu =m;
    }
    
}
