<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>


 <form role="form" action="/board/modify" method="post">
       
	      <div class="form-group">
            <label>Bno</label> <input class="form-control" name='bno'
            value='<c:out value="${board.bno}"/>' readonly="readonly">
          </div>
          
          <div class="form-group">
            <label>Title</label> <input class="form-control" name='title'
            value='<c:out value="${board.title}"/>'>
          </div>

          <div class="form-group">
            <label>Text area</label>
            <textarea class="form-control" rows="3" name='content'><c:out 
            value="${board.content}" /></textarea>
          </div>

          <div class="form-group">
            <label>Writer</label> <input class="form-control" name='writer'
            value='<c:out value="${board.writer}"/>'>
          </div>
          
        
          
          <button type="submit" data-oper='modify' class="btn btn-default">수정하기</button>
          <button type="submit" data-oper='remove' class="btn btn-default">삭제하기</button>
          <button type="submit" data-oper='list' class="btn btn-default">목록으로</button>
          
       </form>

      </div>
      <!--  end panel-body -->

    </div>
    <!--  end panel-body -->
  </div>
  <!-- end panel -->
</div>
<!-- /.row -->
<%@include file="../includes/footer.jsp"%>
<script type="text/javascript">
$(document).ready(function(){
	
	var formObj = $("form"); 
	
	$('button').on("click", function(e){
		
		e.preventDefault();  
		
		
		var operation = $(this).data("oper"); 
		
		
		console.log(operation); 
		
		if(operation === 'remove') {
			formObj.attr("action","/board/remove");
			
		}else if(operation === 'list'){
			formObj.attr("action","/board/list").attr("method","get");
			formObj.empty();
			
			
		} 
		formObj.submit();
		
		
		
	});
	
});
</script>