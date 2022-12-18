package com.devnunu.sample.ui.bottomSheetSample.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.airbnb.mvrx.compose.collectAsState
import com.devnunu.sample.components.bottomSheet.rememberScaffoldBottomSheetView
import com.devnunu.sample.model.BottomSheetState
import com.devnunu.sample.ui.bottomSheetSample.BottomSheetSampleTag
import com.devnunu.sample.ui.bottomSheetSample.BottomSheetSampleViewModel

@Composable
fun BottomSheetSampleBottomSheet(
    viewModelSheetState: BottomSheetState<BottomSheetSampleTag>,
    viewModel: BottomSheetSampleViewModel
) = rememberScaffoldBottomSheetView(
    viewModelSheetState = viewModelSheetState,
    onCloseBottomSheet= viewModel::onCloseBottomSheet
) {
    val bottomSheetTag by viewModel.collectAsState { it.bottomSheetState.tag }
    when (bottomSheetTag) {
        BottomSheetSampleTag.SAMPLE_1 -> {
            BottomSheetSampleTestBottomSheet(
                text = "국가는 균형있는 국민경제의 성장 및 안정과 적정한 소득의 분배를 유지하고, " +
                        "시장의 지배와 경제력의 남용을 방지하며, 경제주체간의 조화를 통한 경제의 민주화를 위하여 경제에 관한 규제와 조정을 할 수 있다.\n" +
                        "모든 국민은 근로의 권리를 가진다. 국가는 사회적·경제적 방법으로 근로자의 고용의 증진과 적정임금의 보장에 노력하여야 하며, " +
                        "법률이 정하는 바에 의하여 최저임금제를 시행하여야 한다."
            )
        }
        BottomSheetSampleTag.SAMPLE_2 -> {
            BottomSheetSampleTestBottomSheet(
                text = "원장은 국회의 동의를 얻어 대통령이 임명하고, 그 임기는 4년으로 하며, 1차에 한하여 중임할 수 있다.\n" +
                        "국가는 국민 모두의 생산 및 생활의 기반이 되는 국토의 효율적이고 균형있는 이용·개발과 보전을 위하여 법률이 정하는 바에 의하여 " +
                        "그에 관한 필요한 제한과 의무를 과할 수 있다."
            )
        }
        BottomSheetSampleTag.SAMPLE_3 -> {
            BottomSheetSampleTestBottomSheet(
                text = "언론·출판은 타인의 명예나 권리 또는 공중도덕이나 사회윤리를 침해하여서는 아니된다. 언론·출판이 타인의 명예나 권리를 침해한 때에는 " +
                        "피해자는 이에 대한 피해의 배상을 청구할 수 있다.\n국가의 세입·세출의 결산, 국가 및 법률이 정한 단체의 회계검사와 행정기관 및 공무원의 " +
                        "직무에 관한 감찰을 하기 위하여 대통령 소속하에 감사원을 둔다.\n국가안전보장회의의 조직·직무범위 기타 필요한 사항은 법률로 정한다."
            )
        }
    }
}