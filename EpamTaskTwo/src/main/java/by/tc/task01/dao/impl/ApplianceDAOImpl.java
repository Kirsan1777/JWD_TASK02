package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.factory.ApplianceFactory;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class ApplianceDAOImpl implements ApplianceDAO{


	@Override
	public Appliance find(Criteria criteria) throws IOException {
		//Могу ли я поменять тип возвращаемого значения, вместо одного прибора вернуть список всех подошедших или мне надо
		// всё равно возвращать только 1 прибор?
		List<Appliance> suitableApplianceOnRequest;
		List<String> allFixturesApplianceTheName = readFileAllName(criteria);
		List<String> allApplianceByCriteria = findTargetAppliance(allFixturesApplianceTheName, criteria);
		suitableApplianceOnRequest = returnSearchItems(allApplianceByCriteria, criteria);

		for(String line : allApplianceByCriteria){
			System.out.println(line);
		}
		for(Appliance appliance : suitableApplianceOnRequest){
			System.out.println(appliance);
		}

		return null/*suitableApplianceOnRequest*/;
	}


	public List<String> readFileAllName(Criteria criteria) throws IOException {
		List<String> listWithAllAppliance = new ArrayList<>();
		FileReader fileReader = new FileReader("C:\\Users\\Nikita\\Desktop\\temp.txt");

		try
		{
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String s;
			while((s=bufferedReader.readLine())!=null){
				if (s.contains(criteria.getGroupSearchName())){
					listWithAllAppliance.add(s);
				}
			}
			bufferedReader.close();
		}
		catch(IOException ex){
			System.out.println(ex.getMessage());

		}

		return listWithAllAppliance;
	}

	public List<String> findTargetAppliance(List<String> listWithAppliance, Criteria criteria){
		List<String> readyApplianceForCustomer = new ArrayList<>();
		Set<String> nameCriteria = criteria.getCriteria().keySet();
		int countOfCriteria = criteria.getCriteria().size();

		for (String strWithAppliance : listWithAppliance) {
			int count = 0;
			for (String preciseNameCriteria : nameCriteria) {

				String valueCriteria = criteria.getCriteria().get(preciseNameCriteria).toString();
				String nameAndValueCriteria = preciseNameCriteria + "=" + valueCriteria;

				if (strWithAppliance.contains(nameAndValueCriteria)) {
					count++;
				}

			}

			if(countOfCriteria == count){
				readyApplianceForCustomer.add(strWithAppliance);
			}

		}



		return readyApplianceForCustomer;
	}

	public List<Appliance> returnSearchItems(List<String> allApplianceByCriteria, Criteria criteria){
		List<Appliance> finishedProduct = new ArrayList<>();
		ApplianceFactory factory = new ApplianceFactory();
		Appliance appliance = null;
		for(String suitableAppliance : allApplianceByCriteria){
			HashMap<String, String> suitableProduct = returnParameters(suitableAppliance);
			appliance = factory.takeAppliance(criteria.getGroupSearchName(), suitableProduct);
			finishedProduct.add(appliance);
		}
		return  finishedProduct;
	}


	public HashMap<String, String> returnParameters(String suitableAppliance) {

		HashMap<String, String> parametersAppliance = new HashMap<>();
		String[] typeAndParameters = suitableAppliance.split(" : ");
		String[] criteriaAppliance = typeAndParameters[1].split(", ");

		for (String criteria : criteriaAppliance) {
			String[] nameAndValue = criteria.split("=");
			parametersAppliance.put(nameAndValue[0], nameAndValue[1]);
		}

		return parametersAppliance;

	}

}
	
	// you may add your own code here
