package guru.springframework.converters;

import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/*Necesitamos convertir del tipo de objeto de dominio hacia atrás o 
 * hacia el objeto de comando y viceversa.*/
/**
 * Created by jt on 6/21/17.
 */
/*SpringFramework tiene una interface para convertir(Converter). Tomado dos tipos*/
@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure>{

	
	/*aca se implementa, toma una de los tipos y lo convierte a otro*/
    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand source) {
        if (source == null) {
            return null;
        }

        final UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(source.getId());
        uom.setDescription(source.getDescription());
        return uom;
    }
}
