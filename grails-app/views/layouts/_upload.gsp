 <div class="export">
   <g:form method="post" action="upload" enctype="multipart/form-data">
     <span class="menuButton">
        <label for="file">Subir Archivo:</label>
     </span>
     <span class="menuButton">
      <input type="file" name="file"/>
     </span>
     <span class="menuButton">
       <input type="submit" value="Upload"/>
     </span>
      <span class="menuButton">
        <input type="hidden" name="control" id="control" value="${request.getRequestURI().split("/")[3]}"/>
     </span>
   </g:form>
 </div>