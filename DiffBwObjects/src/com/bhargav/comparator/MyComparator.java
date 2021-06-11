package com.bhargav.comparator;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class MyComparator {

	public static void main(String[] args) {
		CustomFields customFields = new CustomFields("oTestName", "pTestName");

		OrderLines orderLines1 = new OrderLines("olId1234", customFields);
		OrderLines orderLines2 = new OrderLines("olId5678", customFields);

		List<OrderLines> orderLinesList = Arrays.asList(orderLines1, orderLines2);

		Organisation org = new Organisation("OrgId123", orderLinesList);

		boolean isFieldFound = isFieldWithValueFoundInTheObject(org, "orderLineId", "olId1234"); // true
		// boolean isFieldFound = isFieldWithValueFoundInTheObject(org, "orderName",
		// "oTestName"); //true
		// boolean isFieldFound = isFieldWithValueFoundInTheObject(org, "orderName",
		// "oTeName"); //false
		System.out.println("Is Field Found : " + isFieldFound);
	}

	private static boolean isFieldWithValueFoundInTheObject(Organisation org, String propertyName,
			String propertyValue) {
		try {
			// get all the fields in org object and check if field with property name is
			// available
			Field fields[] = org.getClass().getDeclaredFields();
			for (Field field : fields) {
				if (field.getType() == String.class) {
					if (field.getName().equals(propertyName)) {
						if (field.get(org.getOrgId()).equals(propertyValue)) {
							return true;
						}
					}
				} else if (field.getType() == List.class) { // check if the required field is available in next child
															// level
					List<OrderLines> list = org.getOrderLines();
					for (OrderLines ol : list) {
						Field oFields[] = ol.getClass().getDeclaredFields();
						for (Field oField : oFields) {
							if (oField.getType() == String.class) {
								if (oField.getName().equals(propertyName)) {
									if (oField.get(ol).equals(propertyValue)) {
										return true;
									}
								}
							} else if (oField.getType() == CustomFields.class) {//// check if the required field is
																				//// available in next child level

								Field cFields[] = ol.getCustomFields().getClass().getDeclaredFields();
								for (Field cField : cFields) {
									if (cField.getName().equals(propertyName)) {
										if (cField.get(ol.getCustomFields()).equals(propertyValue)) {
											return true;
										}
									}
								}
							}
						}
					}
				}
			}

		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
