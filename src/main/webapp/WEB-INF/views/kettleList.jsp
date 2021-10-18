<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

 	
	<h1>Dear ${usr} you're now on my kettles page</h1>
	

	<a href="/add-kettle"> <b>Add new kettle</b></a>
	<hr>
		
		<table class="table table-hover table-dark">
			<thead>
					<tr>
						<th scope="col">Image</b></th>
						<th scope="col">Year</b></th>
						<th scope="col">Make</b></th>
						<th scope="col">Model</b></th>
						<th scope="col">Update</b></th>
						<th scope="col">Remove kettle</b></th>
						
					</tr>
			</thead>
			<tbody>
			<c:forEach items="${kettles}" var="kettle">
				<tr>
					<td  ><img src = "${kettle.image}" width="100" height="100" /></td>
					<td  >${kettle.year}</td>
					<td  >${kettle.make}</td>
					<td  >${kettle.model}</td>
					<td><b>&nbsp; &nbsp;
     <a href="/update-kettle?id=${kettle.id}">Update</a>&nbsp;</b></td>
					<td><b>&nbsp; &nbsp;
     <a href="/delete-kettle?id=${kettle.id}">Delete</a></b></td>
				</tr>
			</c:forEach>	
			</tbody>
			
			
		</table>
		
<%@ include file="common/footer.jspf"%>
