package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer {
    private static final double INITIAL_UNITS_ENERGY = 60;

    public NaturalExplorer(String name) {
        super(name, INITIAL_UNITS_ENERGY);
    }

    @Override
    public void search() {
        if (this.getEnergy() < 7) {
            setEnergy(0);
        } else {
            this.setEnergy(this.getEnergy() - 7);
        }
    }
}
