package br.com.boasaude.apirest.dto;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;

public class AbstratAssociadoDto implements GenericRecord {

    @Override
    public Schema getSchema() {
        return null;
    }

    @Override
    public void put(String key, Object v) {

    }

    @Override
    public Object get(String key) {
        return null;
    }

    @Override
    public void put(int i, Object v) {

    }

    @Override
    public Object get(int i) {
        return null;
    }
}
