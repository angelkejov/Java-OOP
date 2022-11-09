package restaurant.repositories.interfaces;

import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TableRepositoryImpl implements TableRepository<Table> {
    private List<Table> tables;

    public TableRepositoryImpl() {
        this.tables = new ArrayList<>();
    }

    @Override
    public Collection<Table> getAllEntities() {
        return null;
    }

    @Override
    public void add(Table entity) {

    }

    @Override
    public Table byNumber(int number) {
        return null;
    }
}
