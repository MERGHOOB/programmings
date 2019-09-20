package vendingMachine.vendingMachines;

import vendingMachine.enums.ItemType;
import vendingMachine.exceptions.CapacityException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VMDifferentCapacityForEachItem extends VendingMachine {



    private Map<ItemType, Integer> capacityMap = new HashMap<>();

    public VMDifferentCapacityForEachItem(List<Integer> capacities) throws CapacityException {

        ItemType[] itemTypes = ItemType.values();
        if(capacities.size() != itemTypes.length) {
            throw new CapacityException("Less values in list");
        }

        for(int i = 0; i<itemTypes.length; i++)
        {
            capacityMap.put(itemTypes[i], capacities.get(i));
        }

    }

    @Override
    int getCapacityForItem(ItemType a) {
        return capacityMap.get(a);
    }


}
