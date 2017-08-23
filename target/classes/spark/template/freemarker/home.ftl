<html>
	Bonjour ${nom}!
	<table border CELLSPACING=0>
	<tr>
      <th>IdAgence</th>
      <th>Nom</th>
      <th>Adresse</th>
    </tr>
		<#list listAgences as obj>	
			<tr ALIGN=center >	
				<td>${obj.idAgence}</td>
				<td>${obj.nom}</td>
				<td>${obj.adresse}</td>
			</tr>
		</#list>
	</table>
	</br>
	<table border CELLSPACING=0>
		<tr>
	      <th>IdAgence</th>
	      <th>Nom</th>
	      <th>Adresse</th>
	    </tr>	
		<tr ALIGN=center >	
			<td>${monAgence.idAgence}</td>
			<td>${monAgence.nom}</td>
			<td>${monAgence.adresse}</td>
		</tr>
	</table>
	
</html>