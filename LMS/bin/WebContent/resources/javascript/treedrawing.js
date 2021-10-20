function drawTree(nodes, treeId){
  var i, j, k; // For loops;
  
  //----------------------------------------------------------------------------
  // Compute for every node thier children.
  var lastLevels = {};  
  lastLevels[nodes[0].level] = 0;
  nodes[0].children = [];
  
  for(i=1; i<nodes.length; i++){
    var curNode = nodes[i];        
    curNode.children = [];
    
    if(lastLevels[curNode.level] != null){
      nodes[lastLevels[curNode.level]].children.push(i);
    }
    else{
      var prevLevel = curNode.level.substring(0, curNode.level.lastIndexOf('.'));
      nodes[lastLevels[prevLevel]].children.push(i);
    }
    lastLevels[curNode.level] = i;
  }
  
  //----------------------------------------------------------------------------
  // Compute Y axis for every node;
  var maxY = 0;
  nodes[0].y = 0;
  for(i=0; i<nodes.length; i++){      
    if(nodes[i].children.length != 0){
      var newY = parseInt(nodes[i].y) + 1;
      
      for(j=0; j<nodes[i].children.length; j++)
        nodes[nodes[i].children[j]].y = newY;
        
      if(newY > maxY)
        maxY = newY;
    }
  }
  
  //----------------------------------------------------------------------------
  // Compute X axis for every node;
  var maxX = -1;
  maxX = assignXToLeaves(nodes, nodes[0], maxX);
  
  for(i=nodes.length-1; i>=0; i--){
    var node = nodes[i];
    
    if(node.x == null){
      node.x = nodes[node.children[Math.floor(node.children.length/2)]].x;
      if(node.children.length % 2 == 0){
        maxX++;
        for(j=0; j<nodes.length ;j++){
          if(j != i && nodes[j].x != null && nodes[j].x >= node.x)
            nodes[j].x++;
        }
      }                
    }
  }
  
  //----------------------------------------------------------------------------
  // Make the 2D nodes array.
  var drawingLocations = new Array(maxX+1);
  for(i=0; i<=maxX; i++)
    drawingLocations[i] = new Array(maxY+1);
    
  for(i=0; i<nodes.length; i++){
    drawingLocations[nodes[i].x][nodes[i].y] = i;
  }
  
  //----------------------------------------------------------------------------
  // Drawing the tree.
  var drawingNode = null;
  var drawing = '';
  drawing += '<table width="100%" border="0" cellpadding="0" cellspacing="0" class="Tasks_textFont" >';  
  
  for(j=0; j<=maxY; j++){
    var hLine = [];
    drawing += '<tr>';
    
    for(i=0; i<=maxX; i++){      
      drawing += '<td valign=top align="center">';
      
      drawingNode = nodes[drawingLocations[i][j]];
      if(drawingNode != null){
        if(drawingNode.children.length > 1){
          hLine.push(nodes[drawingNode.children[0]].x);
          hLine.push(nodes[drawingNode.children[drawingNode.children.length-1]].x);
        }
      
        drawing += '<table border="0" cellpadding="0" cellspacing="0" width="100%" >';
        
        if(j != 0){
          drawing += '<tr>';
            drawing += '<td colspan="2" width="100%">';
              drawing += '<table border="0" cellpadding="0" cellspacing="0" width="100%" style="empty-cells: show;">';
                drawing += '<tr>';
                  drawing += '  <td width="50%" height="15" style="border-left: #ff9900 2px solid"></td>';
                  drawing += '  <td width="50%"></td>';
                drawing += '</tr>';
              drawing += '</table>';
            drawing += '</td>';
          drawing += '</tr>';
        }
        
        if(drawingNode.top != null){
          for(k=0; k < drawingNode.top.length; k+=2){          
            drawing += '<tr>';
            drawing += '  <th width="30%" valign=center align=left style="white-space:nowrap;">' + drawingNode.top[k] + '&nbsp;&nbsp;</th>';
            drawing += '  <td width="70%" valign=center align=right style="white-space:nowrap; font-size: 11px;">' + drawingNode.top[k+1] + '&nbsp;&nbsp;</td>';
            drawing += '</tr>';
          }
        }
        
        drawing += '<tr>';
        drawing += '  <td width="100%" valign=center align=center colspan="2" style="text-align:center!important;">';
        drawing += '    <img src="' + drawingNode.image + '" />';
        drawing += '  </td>';
        drawing += '</tr>';
        
        if(drawingNode.bottom != null){
          for(k=0; k < drawingNode.bottom.length; k+=2){
            drawing += '<tr>';
            drawing += '  <th width="50%" valign=center align=left style="white-space:nowrap;">' + drawingNode.bottom[k] + '&nbsp;&nbsp;</th>';
            drawing += '  <td width="50%" valign=center align=right style="white-space:nowrap; font-size: 11px;">' + drawingNode.bottom[k+1] + '&nbsp;&nbsp;</td>';
            drawing += '</tr>';
          }
        }
        
        if(drawingNode.children.length != 0){
          drawing += '<tr>';
            drawing += '<td colspan="2" width="100%">';
              drawing += '<table border="0" cellpadding="0" cellspacing="0" width="100%" style="empty-cells: show;">';
                drawing += '<tr>';
                  drawing += '  <td width="50%" height="15" style="border-left: #ff9900 2px solid"></td>';
                  drawing += '  <td width="50%"></td>';
                drawing += '</tr>';
              drawing += '</table>';
            drawing += '</td>';
          drawing += '</tr>';
        }
        
        drawing += '</table>';
      }      
      
      drawing += '</td>';
    }
    
    drawing += '</tr>';
    
    if(hLine.length != 0){
      drawing += '<tr>';
      var xFree = 0;
      
      for(k=0; k<hLine.length; k+=2){
        while(xFree < hLine[k]){
          xFree++;
          drawing += '<td></td>';        
        }
        
        drawing += '<td> <table cellpadding="0" cellspacing="0" width="100%" style="empty-cells: show;"><tr> <td width="50%"></td> <td width="50%" style="border-top: Gray 1px solid"></td> </tr></table></td>';
        xFree++;
        
        while(xFree < hLine[k+1]){
          xFree++;
          drawing += '<td> <table cellpadding="0" cellspacing="0" width="100%" style="empty-cells: show;"><tr> <td width="100%" style="border-top: #999999 1px solid"></td></tr></table></td>';
        }
        
        drawing += '<td> <table cellpadding="0" cellspacing="0" width="100%" style="empty-cells: show;"><tr> </td> <td width="50%" style="border-top: #999999 1px solid"></td>  <td width="50%"> </tr></table></td>';
        xFree++;
      }
      
      while(xFree <= maxX){
          xFree++;
          drawing += '<td></td>';        
      }
      
      drawing += '</tr>';
    }
  }
  
  drawing += '</table>';
  
  document.getElementById(treeId).innerHTML = drawing;  
}

function assignXToLeaves(nodes, parent, maxX){
  if(parent.children.length == 0){
    parent.x = ++maxX;
    return maxX;
  }
  
  for(var j=0; j<parent.children.length; j++){
    maxX = assignXToLeaves(nodes, nodes[parent.children[j]], maxX);
  }
  
  return maxX;
}