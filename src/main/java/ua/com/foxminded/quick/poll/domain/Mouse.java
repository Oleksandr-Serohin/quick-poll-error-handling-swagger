package ua.com.foxminded.quick.poll.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Mouse {

    @Id
    @GeneratedValue
    @Column(name = "MOUSE_ID")
    private Long id;

    @Column(name = "MOUSE_NAME")
    @NotNull
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getId() + ", " + getName();
    }
}
