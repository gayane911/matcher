<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<table class="table table-bordered">
  <thead>
    <th>Name</th>
    <th>Email</th>
    <th>Division</th>
    <th>Age</th>
    <th>Timezone</th>
    <th>Matching Score</th>
  </thead>
  <tbody>
    <c:forEach var="matchScore" items="${matchScores}" varStatus="index">
      <tr>
        <td>${matchScore.firstUser.name}</td>
        <td>${matchScore.firstUser.email}</td>
        <td>${matchScore.firstUser.division}</td>
        <td>${matchScore.firstUser.age}</td>
        <td>${matchScore.firstUser.timezone}</td>
        <td rowspan="2">${matchScore.matchScore}%</td>
      </tr>
      <tr>
        <td>${matchScore.secondUser.name}</td>
        <td>${matchScore.secondUser.email}</td>
        <td>${matchScore.secondUser.division}</td>
        <td>${matchScore.secondUser.age}</td>
        <td>${matchScore.secondUser.timezone}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>
