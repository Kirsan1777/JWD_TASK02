package by.tc.task01.factory;

import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.validation.Parser;

import java.util.HashMap;

import static by.tc.task01.entity.criteria.SearchCriteria.Oven.*;
import static by.tc.task01.entity.criteria.SearchCriteria.Laptop.*;
import static by.tc.task01.entity.criteria.SearchCriteria.Refrigerator.*;
import static by.tc.task01.entity.criteria.SearchCriteria.Speakers.*;
import static by.tc.task01.entity.criteria.SearchCriteria.TabletPC.*;
import static by.tc.task01.entity.criteria.SearchCriteria.VacuumCleaner.*;


public class ApplianceFactory {

    public Appliance takeAppliance(String typeAppliance, HashMap<String, String> parametersAppliance){
        Appliance appliance = null;
        Parser parser = new Parser();

        switch (typeAppliance){
            case "Oven":
                appliance = new Oven(
                        parser.parseInt(parametersAppliance.get(SearchCriteria.Oven.POWER_CONSUMPTION.toString())),
                        parser.parseInt(parametersAppliance.get(SearchCriteria.Oven.WEIGHT.toString())),
                        parser.parseInt(parametersAppliance.get(CAPACITY.toString())),
                        parser.parseInt(parametersAppliance.get(DEPTH.toString())),
                        parser.parseDouble(parametersAppliance.get(SearchCriteria.Oven.HEIGHT.toString())),
                        parser.parseDouble(parametersAppliance.get(SearchCriteria.Oven.WIDTH.toString())));
                break;
            case "Laptop":
                appliance = new Laptop(
                        parser.parseDouble(parametersAppliance.get(SearchCriteria.Laptop.BATTERY_CAPACITY.toString())),
                        parametersAppliance.get(OS.toString()),
                        parser.parseInt(parametersAppliance.get(SearchCriteria.Laptop.MEMORY_ROM.toString())),
                        parser.parseInt(parametersAppliance.get(SYSTEM_MEMORY.toString())),
                        parser.parseDouble(parametersAppliance.get(CPU.toString())),
                        parser.parseInt(parametersAppliance.get(DISPLAY_INCHS.toString())) );
                break;
            case "Refrigerator":
                appliance = new Refrigerator(
                        parser.parseInt(parametersAppliance.get(OVERALL_CAPACITY.toString())),
                        parser.parseInt(parametersAppliance.get(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString())),
                        parser.parseInt(parametersAppliance.get(SearchCriteria.Refrigerator.WEIGHT.toString())),
                        parser.parseInt(parametersAppliance.get(FREEZER_CAPACITY.toString())),
                        parser.parseInt(parametersAppliance.get(SearchCriteria.Refrigerator.HEIGHT.toString())),
                        parser.parseInt(parametersAppliance.get(SearchCriteria.Refrigerator.WIDTH.toString()))
                );
                break;
            case "Speakers":
                appliance = new Speakers(
                        parser.parseInt(parametersAppliance.get(SearchCriteria.Speakers.POWER_CONSUMPTION.toString())),
                        parser.parseInt(parametersAppliance.get(NUMBER_OF_SPEAKERS.toString())),
                        parametersAppliance.get(FREQUENCY_RANGE.toString()),
                        parser.parseInt(parametersAppliance.get(CORD_LENGTH.toString()))
                );
                break;
            case "TabletPC":
                appliance = new TabletPC(
                        parser.parseInt(parametersAppliance.get(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString())),
                        parser.parseInt(parametersAppliance.get(DISPLAY_INCHES.toString())),
                        parser.parseInt(parametersAppliance.get(SearchCriteria.TabletPC.MEMORY_ROM.toString())),
                        parser.parseInt(parametersAppliance.get(FLASH_MEMORY_CAPACITY.toString())),
                        parametersAppliance.get(COLOR.toString())
                );
                break;
            case "VacuumCleaner":
                appliance = new VacuumCleaner(
                        parser.parseInt(parametersAppliance.get(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString())),
                        parametersAppliance.get(FILTER_TYPE.toString()),
                        parametersAppliance.get(BAG_TYPE.toString()),
                        parametersAppliance.get(WAND_TYPE.toString()),
                        parser.parseInt(parametersAppliance.get(MOTOR_SPEED_REGULATION.toString())),
                        parser.parseInt(parametersAppliance.get(CLEANING_WIDTH.toString()))
                );
                break;
        }
        return  appliance;
    }

}
