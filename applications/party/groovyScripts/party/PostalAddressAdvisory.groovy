import org.apache.ofbiz.party.contact.*

partyId = parameters.partyId
Map mechMap = new HashMap()
ContactMechWorker.getContactMechAndRelated(request, partyId, mechMap)
Map postalAddress = mechMap.get("postalAddress")
if (postalAddress == null){
    "notMars"
}
String planet = postalAddress.get("planet")
if (planet == null || !planet.equalsIgnoreCase("Mars")){
    "notMars"
} else {
    "isMars"
}