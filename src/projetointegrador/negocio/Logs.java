package projetointegrador.negocio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "Logs")

public class Logs implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private int log_id;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "dated")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dated;
    
    @Column(name = "logger")
    private String logger;
    
    @Column(name = "level")
    private String level;
    
    @Column(name = "message")
    private String message;

    public Logs() {
    }

    public Calendar getDated() {
        return dated;
    }

    public void setDated(Calendar dated) {
        this.dated = dated;
    }

    public String getLogger() {
        return logger;
    }

    public void setLogger(String logger) {
        this.logger = logger;
    }

    public String getLevel() {
        return level;
    }

    public int getLog_id() {
        return log_id;
    }

    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }

    public String getUser() {
        return username;
    }

    public void setUser(String user) {
        this.username = user;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
    
}
