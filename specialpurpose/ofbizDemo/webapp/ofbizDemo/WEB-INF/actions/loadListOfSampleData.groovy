ArrayList listOfRecords = new ArrayList();
for(int i=1; i <=3; i++){
    HashMap row = new HashMap();
    row.put("firstName","First " + i);
    row.put("lastName","Last " + i);
    listOfRecords.add(row);
}
context.put("listOfRecords", listOfRecords);