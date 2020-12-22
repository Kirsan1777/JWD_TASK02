package by.tc.task01.dao;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.io.IOException;

public interface ApplianceDAO { //Функиональный интерфейс
	Appliance find(Criteria criteria) throws IOException;
}
