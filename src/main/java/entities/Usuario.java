package entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGenerator")
    @GenericGenerator(
            name = "idGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = SequenceStyleGenerator.CONFIG_PREFER_SEQUENCE_PER_ENTITY, value = "true")
            }
    )
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String cpf;
    private String email;
    private String password;

    public Usuario(){}

    public Usuario(Long id, String name, LocalDate birthDate, String cpf, String email, String password){
        this.id = id;
        this.birthDate = birthDate;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
    }

}
