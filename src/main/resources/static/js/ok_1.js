

var select2a =['A316', 'A411' , 'A413', 'A414'];
var select2b1 =['D101', 'D102','D103','D104','D105','D106','D107','D108','D109','D114',
'D115','D116','D117','D118','D119','D120'];
var select2b2 = ['트리니티오디토리움(284)','D201','D203','D204','D205','D206','D207','D208','D209','D210','D211','D215','D216','D218',
'D219','D220','D222','D224','D225','D227','D227','D228','D229','D230','D231'];
var select2b3 = ['D301','D302','D303','D304','D305','D306','D307','D308','D309','D310','D313','D314',
'D315','D316','D317','D318','D319','D320','D321','D324','D325','D326','D327'];
var select2b4 = ['D402','D403','D404','D405','D407','D408','D409','D410','D411','D412','D413','D414','D415','D416','D417','D418','D419',
'D412','D422','D432','D433','D435','D436','D438','D439','D441','D442'];
var select2i = ['I202','I204','I205','I206','I207','I209','I210','I213','I214','I215','I219','I302',
'I303','I314','I315','I415','I419','I420','I426'];
var select2g = ['만오오디토리움(351)','만오기념홀'];

function itemChange() {
    var select2Options = {
        "A동": select2a,
        "D동 1층": select2b1,
        "D동 2층": select2b2,
        "D동 3층": select2b3,
        "D동 4층": select2b4,
        "I동": select2i,
        "G동": select2g
    };

    var selectedBuilding = document.getElementById('select1').value;
    var selectElement = document.getElementById('select2');

    if (selectedBuilding in select2Options) {
        addOptions(selectElement, select2Options[selectedBuilding]);
    } else {
        addOptions(selectElement, []);
    }
}

function addOptions(selectElement, options) {
    selectElement.innerHTML = '<option value="">강의실 선택</option>';

    options.forEach(function(option) {
        var optionElement = document.createElement('option');
        optionElement.value = option;
        optionElement.textContent = option;
        selectElement.appendChild(optionElement);
    });
}
