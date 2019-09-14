$(document).ready(function() {
			shows();
		});

var url = '/boot-demo/soldier/soldierTableHandler';// URL

var nextPage = document.getElementById("nextPage");// 下一页标签节点

var previousPage = document.getElementById("previousPage");// 上一页标签节点

var currentPageNum = null;// 现第几页

var totalPage = null;// 总页数

var n = 1;// 表格列序号

/**
 * 预先展示第一页分页表格数据
 */
function shows() {
	$.ajax({
				url : url,
				type : 'GET',
				dataType : 'json',
				success : function(js) {
					if (js != null) {
						console.log(js.list);
						console.log(js.list.length);

						$('#soldier_table_tobody').empty();

						for (var i = 0; i < js.list.length; i++) {
							// TBODY内容
							var tbody = "<tr>" + "<td>" + n++ + "</td>"
									+ " <td>#{soldierId}</td>"
									+ "<td>#{soldierName}</td>"
									+ "<td>#{joinArmyTime}</td>" + "</tr>";

							tbody = tbody.replace(/#{soldierId}/g,
									js.list[i].soldierId);
							tbody = tbody.replace(/#{soldierName}/g,
									js.list[i].soldierName);
							tbody = tbody.replace(/#{joinArmyTime}/g,
									js.list[i].joinArmyTime);

							$('#soldier_table_tobody').append(tbody);

						}

						// 总页数
						$('#total_page').text(js.pages);

						// 当前页
						$('#current_page').text(js.pageNum);

						// 判断是否为末页
						switch (js.hasNextPage) {
							case false :
								nextPage.style.display = "none";
								break;

							case true :
								nextPage.style.display = "block";
								break;
						}

						// 判断是否还有上页
						switch (js.hasPreviousPage) {
							case false :
								previousPage.style.display = "none";
								break;

							case true :
								previousPage.style.display = "block";
								break;
						}

						// 赋值-当前页
						currentPageNum = js.pageNum;

						// 赋值,总页数
						totalPage = js.pages;
					}
				}

			});

	n = 1;
}

/**
 * 跳至指定页
 */
function jumpToAssignPage() {
	// 获取输入
	var input = $('#assign_input').val();
	console.log('input- ' + input);

	// 若输入小于1或大于总页数,中止
	if (input < 1 || input > totalPage) {
		alert('超出范围');
		return;
	}

	// 若输入的不是非零正整数的数字
	var Expression = /^\+?[1-9][0-9]*$/;
	var objExp = new RegExp(Expression);
	if (objExp.test(input) !== true) {
		alert('输入的不是非零正整数的数字');
		return false;
	}

	$.ajax({
				url : url,
				type : 'GET',
				data : {
					'pageNum' : input
				},
				dataType : 'json',
				success : function(info) {
					if (info != null) {
						executeShows(info);
					} else {
						console.log('fatal');
					}
				}
			});
}

/**
 * 下一页数据
 */
function jumpToNextPage() {
	// 当前页加一
	currentPageNum++;

	if (currentPageNum > totalPage) {
		console.log('没有下一页了');
		return;
	}

	$.ajax({
				url : url,
				data : {
					'pageNum' : currentPageNum
				},
				type : 'GET',
				dataType : 'json',
				success : function(info) {
					if (info != null) {
						if (info.pageNum <= info.pages) {// 如果当前页不超过总页数
							executeShows(info);
						} else {
							console.log('error');
						}
					}
				}

			});
}

/**
 * 跳至上一页
 */
function jumpToPreviousPage() {
	// 当前页减一
	currentPageNum--;

	// 若小于第1页
	if (currentPageNum < 1) {
		console.log('没有上一页了');
		return;
	}

	$.ajax({
				url : url,
				type : 'GET',
				data : {
					'pageNum' : currentPageNum
				},
				dataType : 'json',
				success : function(info) {
					if (info != null) {
						if (info.pageNum >= info.navigateFirstPage) {
							executeShows(info);
						} else {
							console.log('error');
						}
					}
				}
			});
}

/**
 * 封装分页展示表格函数
 * 
 * @param {}
 *            info
 */
function executeShows(info) {
	$('#soldier_table_tobody').empty();

	for (var i = 0; i < info.list.length; i++) {
		// TBODY内容
		var tbody = "<tr>" + "<td>" + n++ + "</td>" + " <td>#{soldierId}</td>"
				+ "<td>#{soldierName}</td>" + "<td>#{joinArmyTime}</td>"
				+ "</tr>";

		tbody = tbody.replace(/#{soldierId}/g, info.list[i].soldierId);
		tbody = tbody.replace(/#{soldierName}/g, info.list[i].soldierName);
		tbody = tbody.replace(/#{joinArmyTime}/g, info.list[i].joinArmyTime);

		$('#soldier_table_tobody').append(tbody);

	}

	// 总页数
	$('#total_page').text(info.pages);

	// 当前页
	$('#current_page').text(info.pageNum);

	// 判断是否为末页
	switch (info.hasNextPage) {
		case false :
			nextPage.style.display = "none";
			break;

		case true :
			nextPage.style.display = "block";
			break;
	}

	// 判断是否还有上页
	switch (info.hasPreviousPage) {
		case false :
			previousPage.style.display = "none";
			break;

		case true :
			previousPage.style.display = "block";
			break;
	}

	n = 1;
}
