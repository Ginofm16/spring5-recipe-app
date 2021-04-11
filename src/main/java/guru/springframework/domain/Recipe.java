package guru.springframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jt on 6/13/17.
 */
@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    @Lob
    private String directions;
    //todo add
    //private Difficulty difficulty;

    /*Anotacion que permote almacenar mas caracteres de los que permite el tipo de la variable*/
    /*Esta anotacion creara como un campo objeto largo binario o un campo blob(para largos
    objetos binary) dentro de la base de datos*/
    @Lob
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    /*al estar con lombok se presentara un error de desbordamiento y por el codigo hash, 
     * ya que se tiene referencias bidireccionales, se creara una referencias circular. Para
     * ello realizamos la anotacion en Ingredient @EqualsAndHashCode(exclude = "recipe")*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    /*EnumType de tipo STRING, para que persista los emun como texto*/
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    //para guardar datos de id en una relacion bidireccional OnetoOne
    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }

    public Recipe addIngredient(Ingredient ingredient){
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }

}
